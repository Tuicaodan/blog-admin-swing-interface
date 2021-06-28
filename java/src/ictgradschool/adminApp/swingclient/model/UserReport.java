package ictgradschool.adminApp.swingclient.model;

import java.util.*;

public class UserReport {

    private List<User> _reportIndex;
    private Map<Integer,User>  _report;

    private List<UserReportListener> _listeners;

    public UserReport(){
        _reportIndex= new ArrayList<>();
    }


    public UserReport(List<User> userList){

        this._reportIndex = userList;

        _report = new HashMap<Integer,User>();

        for(User user : _reportIndex) {
            _report.put(user.getUserID(), user);
        }

        _listeners = new ArrayList<UserReportListener>();

    }

    public int getNumberOfUsers(){ return _reportIndex.size();}

    public User getUserAt(int index){return _reportIndex.get(index);}

    public int getIndexFor(User user){return  _reportIndex.indexOf(user);}

    public void addUserReportListener(UserReportListener listener){
        _listeners.add(listener);
    }


    //wipe user's info and notify all the listeners about the deleted user.
    public void changeDeletedUserInfo(int userID){
        User deletedUser = _report.get(userID);
        if(deletedUser!= null){
            deletedUser.setFirstName("");
            deletedUser.setLastName("");
            deletedUser.setDateOfBirth("");
            deletedUser.setAvatarImage("/deleteIcon");
            deletedUser.setIntroduction("User was deleted");
            deletedUser.setNumberOfArticles(0);

            for(UserReportListener listener: _listeners){
                listener.update(deletedUser);
            }
        }
    }
}
