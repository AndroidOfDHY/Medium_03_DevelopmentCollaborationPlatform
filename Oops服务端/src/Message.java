
public class Message {
	public void decomposition(String talk,Client client){
		System.out.println(talk);
		String info[] = talk.split(",");
		if(info[0].equals("dl")){
			String pass;
			Database db = new Database();
			db.connect();
			pass = MD5Util.md5(info[2]);
			db.login(info[1], pass, client);
		}
		if(info[0].equals("project")){
			Database db = new Database();
			db.connect();
			db.getProjectInfo(client);
		}
		if(info[0].equals("people")){
			Database db = new Database();
			db.connect();
			db.getPeopleInfo(client);
		}
		if(info[0].equals("schedule")){
			Database db = new Database();
			db.connect();
			db.getSchedule(client,info[1]);
		}
		if(info[0].equals("group")){
			Database db = new Database();
			db.connect();
			db.getGroup(client, info[1], info[2],info[3]);
		}
		if(info[0].equals("delete")){
			Database db = new Database();
			db.connect();
			db.deletePeople(client, info[1], info[2]);
		}
		if(info[0].equals("modify")){
			Database db = new Database();
			db.connect();
			db.modidy_info(client, info[1], info[2], info[3], info[4], info[5]);
		}
		if(info[0].equals("deletepeople")){
			Database db = new Database();
			db.connect();
			db.deletePeople(client, info[1]);
		}
	}
}
