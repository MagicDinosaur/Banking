package account.domain.model;

import lombok.NonNull;

import java.time.LocalDateTime;

public class ActivityWindow {
//    TODO: fix timestamp in corresopnding to activity
    private  List<Activity> activities;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public LocaDateTime endTimestamp() {
        return timestamp;
    }
    public ActivityWindow(@NonNull List<Activity> activities) {
        this.activities = activities;
    }

    public ActivityWindow(@NonNull Activity... activities) {
        this.activities = new ArrayList<>(Arrays.asList(activities));
    }

    public List<Activity> getActivities() {
        return Collections.unmodifiableList(this.activities);
    }

    public void addActivity(Activity activity) {
        this.activities.add(activity);
    }

}
