/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gym.general.table;

import com.gym.general.model.ModelMember;

/**
 *
 * @author DELL
 */
public class ModelAction {
     public ModelMember getStudent() {
        return student;
    }

    public void setStudent(ModelMember student) {
        this.student = student;
    }

    public EventAction getEvent() {
        return event;
    }

    public void setEvent(EventAction event) {
        this.event = event;
    }

    public ModelAction(ModelMember student, EventAction event) {
        this.student = student;
        this.event = event;
    }

    public ModelAction() {
    }

    private ModelMember student;
    private EventAction event;
}
