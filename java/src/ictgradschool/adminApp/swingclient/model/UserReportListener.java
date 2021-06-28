package ictgradschool.adminApp.swingclient.model;

public interface UserReportListener {
    /**
     * Notifies a UserReportListener that a user within the UserReport has
     * been updated.
     *
     * @param user the user object within the UserReport that has changed.
     */
    void update(User user);
}
