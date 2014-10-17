package org.ys.idao;

import org.ys.commons.Admin;

public interface IAdminDAO extends IGenericDAO<Admin, Long> {
		public Admin getAdmin(String username);
}
