package com.xumengqi.reme.dao.entity;

import java.io.Serializable;

public class SchoolCalendar implements Serializable {
    /**
     * 主键
     *
     * @mbg.generated
     */
    private Long schoolCalendarId;

    /**
     * 年次
     *
     * @mbg.generated
     */
    private Integer year;

    /**
     * 校历附件ID
     *
     * @mbg.generated
     */
    private Long calendarAttachId;

    private static final long serialVersionUID = 1L;

    public Long getSchoolCalendarId() {
        return schoolCalendarId;
    }

    public void setSchoolCalendarId(Long schoolCalendarId) {
        this.schoolCalendarId = schoolCalendarId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Long getCalendarAttachId() {
        return calendarAttachId;
    }

    public void setCalendarAttachId(Long calendarAttachId) {
        this.calendarAttachId = calendarAttachId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", schoolCalendarId=").append(schoolCalendarId);
        sb.append(", year=").append(year);
        sb.append(", calendarAttachId=").append(calendarAttachId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}