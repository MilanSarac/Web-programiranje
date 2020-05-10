package data;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.User;

public class UserRepository {
	public String path = "C:\\Users\\23\\workspace\\WP2020\\Aapartmani\\WebContent\\data\\users.json";
	
	
	
	@SuppressWarnings("unchecked")
	public void addUser(User user)throws IOException{
		File file=new File(path);
		JSONArray allUsers=new JSONArray();
		allUsers= (JSONArray)GetUsers();
		JSONObject userObject = new JSONObject();
		userObject.put("Username", user.getUsername());
		userObject.put("Name", user.getName());
		userObject.put("SureName", user.getSureName());
		//userObject.put("Gender", user.getGenre());
		userObject.put("Male", user.getMale());
		userObject.put("Female", user.getFemale());
		userObject.put("Password", user.getPassword());
		userObject.put("PasswordControl", user.getPasswordControl());
		allUsers.add(userObject);
		FileWriter file1= new FileWriter(file);
		file1.write(allUsers.toJSONString());
		file1.flush();
		file1.close();
	}


	public ArrayList<User> GetUsers() throws IOException {
		File file= new File(path);
		FileReader fileReader = new FileReader(file);
		JSONParser jsonParser = new JSONParser();
		Object obj;
		JSONArray jsonArray = null;
		try {
			obj= jsonParser.parse(fileReader);
			jsonArray= (JSONArray)obj;
		}catch (ParseException e) {
			e.printStackTrace();
		}
		return jsonArray;
	}
}
