# CargoTransportation
Team 6
LOCO and Thunder



public List<Staff> getactiveStaff(int role_Id, int activeid) {
		List<Staff> staffList = new ArrayList<>();

		try {
			Staff staff = new Staff();
			PreparedStatement ps = this.dbConfig.getConnection()
					.prepareStatement("select * from cargotransportation.staff where staff.role_id=" + role_Id
							+ " AND staff.is_active=" + activeid + ";");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				staff = Staff_mapper.mapper(staff, rs);
				staffList.add(staff);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return staffList;
	}
