package pl.softwaremill.timesheet_exporter.transform;

import java.util.Date;

public class DataRow {

    private String user;
    private String project;
    private String userStory;
    private String task;
    private Date date;
    private float timeSpent;
    private double userStoryEstimation;
    private double taskEstimation;

    public DataRow(String user, String project, String userStory, String task, Date date, float timeSpent,
                   double userStoryEstimation, double taskEstimation) {
        this.user = user;
        this.project = project;
        this.userStory = userStory;
        this.task = task;
        this.date = date;
        this.timeSpent = timeSpent;
        this.userStoryEstimation = userStoryEstimation;
        this.taskEstimation = taskEstimation;
    }

    public String getUser() {
        return user;
    }

    public String getProject() {
        return project;
    }

    public String getUserStory() {
        return userStory;
    }

    public String getTask() {
        return task;
    }

    public Date getDate() {
        return date;
    }

    public float getTimeSpent() {
        return timeSpent;
    }

    public double getUserStoryEstimation() {
        return userStoryEstimation;
    }

    public double getTaskEstimation() {
        return taskEstimation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DataRow)) return false;

        DataRow dataRow = (DataRow) o;

        if (Float.compare(dataRow.timeSpent, timeSpent) != 0) return false;
        if (date != null ? !date.equals(dataRow.date) : dataRow.date != null) return false;
        if (project != null ? !project.equals(dataRow.project) : dataRow.project != null) return false;
        if (task != null ? !task.equals(dataRow.task) : dataRow.task != null) return false;
        if (user != null ? !user.equals(dataRow.user) : dataRow.user != null) return false;
        if (userStory != null ? !userStory.equals(dataRow.userStory) : dataRow.userStory != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (project != null ? project.hashCode() : 0);
        result = 31 * result + (userStory != null ? userStory.hashCode() : 0);
        result = 31 * result + (task != null ? task.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (timeSpent != +0.0f ? Float.floatToIntBits(timeSpent) : 0);
        return result;
    }

    public String getValue(String field) {
        try {
            Object o = getClass().getDeclaredField(field).get(this);

            if (o == null) {
                return "";
            }
            else {
                return o.toString();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
