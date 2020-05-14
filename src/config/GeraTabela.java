package config;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class GeraTabela {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration().configure("config/hibernate.cfg.xml");
		new SchemaExport(cfg).create(true, true);
		
	}
	

}
