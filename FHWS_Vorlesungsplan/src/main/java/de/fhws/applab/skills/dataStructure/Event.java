package de.fhws.applab.skills.dataStructure;

import java.util.ArrayList;

/**
 * Created by Florian Hohn on 23.06.2017.
 */
public class Event {
  protected String endTime;
  protected String name;
  protected String startTime;
  protected String type;

  protected ArrayList<LecturerView> lecturerViews;
  protected ArrayList<RoomsView> roomsView;
  protected ArrayList<StudentsView> studentsView;

  public ArrayList<LecturerView> getLecturerViews() {
    return lecturerViews;
  }

  public void setLecturerViews(ArrayList<LecturerView> lecturerViews) {
    this.lecturerViews = lecturerViews;
  }

  public ArrayList<RoomsView> getRoomsView() {
    return roomsView;
  }

  public void setRoomsView(ArrayList<RoomsView> roomsView) {
    this.roomsView = roomsView;
  }

  public ArrayList<StudentsView> getStudentsView() {
    return studentsView;
  }

  public void setStudentsView(ArrayList<StudentsView> studentsView) {
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
