package com.lambdaschool.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructor")
public class Instructor
{
    @ApiModelProperty(name = "instructid", value = "Primary key for Instructor", required = true, example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long instructid;

    @ApiModelProperty(name = "instructname", value = "Instructor's Name", required = true, example = "John")
    private String instructname;

    //there is no example on this one left it blank because the example is a list...
    @ApiModelProperty(name = "courses", value = "Courses the Instructor teaches", required = true)
    @OneToMany(mappedBy = "instructor")
    @JsonIgnoreProperties("instructors")
    private List<Course> courses = new ArrayList<>();

    public Instructor()
    {
    }

    public Instructor(String instructname)
    {
        this.instructname = instructname;
    }

    public long getInstructid()
    {
        return instructid;
    }

    public void setInstructid(long instructid)
    {
        this.instructid = instructid;
    }

    public String getInstructname()
    {
        return instructname;
    }

    public void setInstructname(String instructname)
    {
        this.instructname = instructname;
    }

    public List<Course> getCourses()
    {
        return courses;
    }

    public void setCourses(List<Course> courses)
    {
        this.courses = courses;
    }
}
