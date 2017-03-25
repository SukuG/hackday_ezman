package dbnizar.com.dbnizar.dbnizarbase.model.common;

import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.List;

/**
 * Created by sukumar on 3/25/2017
 */
@JsonObject(fieldDetectionPolicy = JsonObject.FieldDetectionPolicy.NONPRIVATE_FIELDS_AND_ACCESSORS)
public class ProjectListModel {

    private List<ProjectListModelData> projectdetails;

    public List<ProjectListModelData> getProjectdetails() {
        return projectdetails;
    }

    public void setProjectdetails(List<ProjectListModelData> projectdetails) {
        this.projectdetails = projectdetails;
    }
}
