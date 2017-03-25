package dbnizar.com.dbnizar.dbnizarbase.model.dto.response;

import com.bluelinelabs.logansquare.annotation.JsonObject;

import dbnizar.com.dbnizar.dbnizarbase.model.common.ProjectListModel;

/**
 * Created by sukumar on 3/25/2017
 */
@JsonObject(fieldDetectionPolicy = JsonObject.FieldDetectionPolicy.NONPRIVATE_FIELDS_AND_ACCESSORS)
public class ProjectListResponse extends BaseResponse {

    private ProjectListModel data;

    public ProjectListModel getData() {
        return data;
    }

    public void setData(ProjectListModel data) {
        this.data = data;
    }
}
