package com.cn.lon.entity;

public class AddandCut {
    private Integer id;

    private String type;

    private String stuid;

    private Double score;

    private String explains;

    private String pictureurl;

    private String checked;

    private String checkemanid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid == null ? null : stuid.trim();
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getExplains() {
        return explains;
    }

    public void setExplains(String explains) {
        this.explains = explains == null ? null : explains.trim();
    }

    public String getPictureurl() {
        return pictureurl;
    }

    public void setPictureurl(String pictureurl) {
        this.pictureurl = pictureurl == null ? null : pictureurl.trim();
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked == null ? null : checked.trim();
    }

    public String getCheckemanid() {
        return checkemanid;
    }

    public void setCheckemanid(String checkemanid) {
        this.checkemanid = checkemanid == null ? null : checkemanid.trim();
    }
}