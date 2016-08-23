package com.chw.again.entity;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.EL;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Prev;
import org.nutz.dao.entity.annotation.Table;
/**
 * 
 * @author chw
 *
 */
@Table("sys_task")
public class Task {
	
	@Name
	@Column
	@ColDefine(type=ColType.VARCHAR,width=32)
	@Prev(els={@EL("uuid()")})
	private String id;
	
	@Column("class_name")
	@ColDefine(type=ColType.VARCHAR,width=255)
	private String className;
	
	@Column("cron")
	@ColDefine(type=ColType.VARCHAR,width=20)
	private String cron;
	
	@Column
	@ColDefine(type=ColType.VARCHAR,width=255)
	private String comment;
	
	@Column
	@ColDefine(type=ColType.BOOLEAN)
	private Boolean flag = Boolean.TRUE;//true=启用

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}

	public String getComment() {
		return comment;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", className=" + className + ", cron=" + cron + ", comment=" + comment + ", flag="
				+ flag + "]";
	}
	
	
	
	
}
