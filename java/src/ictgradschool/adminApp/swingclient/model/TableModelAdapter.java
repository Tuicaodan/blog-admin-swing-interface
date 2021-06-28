package ictgradschool.adminApp.swingclient.model;

import javax.swing.table.AbstractTableModel;

public class TableModelAdapter extends AbstractTableModel implements UserReportListener {
    private static String[]  COLUMN_NAMES = { "userID", "username", "First Name", "Last Name", "Date of Birth", "Avatar Image", "Introduction", "Number of Articles"};
    private UserReport _adaptee;

    public TableModelAdapter(UserReport userReport){
        _adaptee = userReport;
    }

    @Override
    public int getRowCount() {
        return _adaptee.getNumberOfUsers();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public String getColumnName(int index) {
        return COLUMN_NAMES[index];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        User user = _adaptee.getUserAt(rowIndex);
        Object result = null;

        switch (columnIndex){
            case 0:
                result = user.getUserID();
                break;
            case 1:
                result = user.getUsername();
                break;
            case 2:
                result = user.getFirstName();
                break;
            case 3:
                result = user.getLastName();
                break;
            case 4:
                result = user.getDateOfBirth();
                break;
            case 5:
                result = user.getAvatarImage();
                break;
            case 6:
                result = user.getIntroduction();
                break;
            case 7:
                result = user.getNumberOfArticles();
                break;
        }

        return result;
    }


    @Override
    public void update(User user) {
        // Fire a TableModelEvent so that the JTable view can update the row
        // used to display the user object that has changed.
        int rowIndex = _adaptee.getIndexFor(user);
        fireTableRowsUpdated(rowIndex,rowIndex);
    }
}
