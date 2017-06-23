package de.fhws.applab.skills.dataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Florian Hohn on 23.06.2017.
 */
public class Event {
  private String endTime;
  private String name;
  private String startTime;
  private String type;

  private List<LecturerView> lecturerView;
  private List<RoomsView> roomsView;
  private List<StudentsView> studentsView;

  public List<LecturerView> getLecturerView() {
    return lecturerView;
  }

  public void setLecturerView(List<LecturerView> lecturerView) {
    this.lecturerView = lecturerView;
  }

  public List<RoomsView> getRoomsView() {
    return roomsView;
  }

  public void setRoomsView(List<RoomsView> roomsView) {
    this.roomsView = roomsView;
  }

  public List<StudentsView> getStudentsView() {
    return studentsView;
  }

  public void setStudentsView(List<StudentsView> studentsView) {
    this.studentsView = studentsView;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

}
