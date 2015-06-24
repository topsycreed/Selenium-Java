package com.example.tests;

public class GroupData implements Comparable<GroupData> {
	public String groupName;
	public String header;
	public String footer;

	public GroupData(String groupName, String header, String footer) {
		this.groupName = groupName;
		this.header = header;
		this.footer = footer;
	}
	
	public GroupData() {
	}

	@Override
	public String toString() {
		return "GroupData [groupName=" + groupName + ", header=" + header
				+ ", footer=" + footer + "]";
	}

	@Override
	public int hashCode() {
	int result = 1;
	return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroupData other = (GroupData) obj;
		if (groupName == null) {
			if (other.groupName != null)
				return false;
		} else if (!groupName.equals(other.groupName))
			return false;
		return true;
	}

	@Override
	public int compareTo(GroupData other) {
		return this.groupName.toLowerCase().compareTo(other.groupName.toLowerCase());
	}
}