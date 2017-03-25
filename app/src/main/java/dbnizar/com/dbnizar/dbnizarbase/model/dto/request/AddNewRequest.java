package dbnizar.com.dbnizar.dbnizarbase.model.dto.request;

import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Created by sukumar on 3/25/2017
 */
@JsonObject(fieldDetectionPolicy = JsonObject.FieldDetectionPolicy.NONPRIVATE_FIELDS_AND_ACCESSORS)
public class AddNewRequest extends BaseRequest {

    private String platform;

    private String clientTimeline;

    private String internalTimeline;

    private String projectManagerName;

    private String internalBudget;

    private String clientName;

    private String projectmanagerId;

    private String adminBudget;

    private String type;

    private String projectName;

    private String clientEmail;

    private String officialStartDate;

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getClientTimeline() {
        return clientTimeline;
    }

    public void setClientTimeline(String clientTimeline) {
        this.clientTimeline = clientTimeline;
    }

    public String getInternalTimeline() {
        return internalTimeline;
    }

    public void setInternalTimeline(String internalTimeline) {
        this.internalTimeline = internalTimeline;
    }

    public String getProjectManagerName() {
        return projectManagerName;
    }

    public void setProjectManagerName(String projectManagerName) {
        this.projectManagerName = projectManagerName;
    }

    public String getInternalBudget() {
        return internalBudget;
    }

    public void setInternalBudget(String internalBudget) {
        this.internalBudget = internalBudget;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getProjectmanagerId() {
        return projectmanagerId;
    }

    public void setProjectmanagerId(String projectmanagerId) {
        this.projectmanagerId = projectmanagerId;
    }

    public String getAdminBudget() {
        return adminBudget;
    }

    public void setAdminBudget(String adminBudget) {
        this.adminBudget = adminBudget;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getOfficialStartDate() {
        return officialStartDate;
    }

    public void setOfficialStartDate(String officialStartDate) {
        this.officialStartDate = officialStartDate;
    }

    @Override
    public String toString() {
        return "ClassPojo [platform = " + platform + ", clientTimeline = " + clientTimeline + ", internalTimeline = " + internalTimeline + ", projectManagerName = " + projectManagerName + ", internalBudget = " + internalBudget + ", clientName = " + clientName + ", projectmanagerId = " + projectmanagerId + ", adminBudget = " + adminBudget + ", type = " + type + ", projectName = " + projectName + ", clientEmail = " + clientEmail + ", officialStartDate = " + officialStartDate + "]";
    }
}
