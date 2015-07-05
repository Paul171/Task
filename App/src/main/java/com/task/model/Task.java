package com.task.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Task")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Content")
	private String content;
	
	@Column(name = "Priority")
	private String priority;
	
	public Task(){}
	
	public Task(Long id){
		this.id = id;
	}
	public Task(String name, String content, String priority){
		this.name = name;
		this.content = content;
		this.priority = priority;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getPriority(){
		return priority;
	}
	public void setPriority(String priority){
		this.priority = priority;
	}
	public String getContent(){
		return content;
	}
	public void setContent(String content){
		this.content = content;
	}
	public Long getId(){
		return id;
	}
	 @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);

        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Task)) {
            return false;
        }
        Task other = (Task) object;

        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {

            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Task.Task[id=" + id + "]";
    }
}
