import java.util.ArrayList;
import java.util.HashMap;

interface phone{

ArrayList<Call> callHistory=new ArrayList<Call>();
HashMap<Long,String> contactList=new HashMap<Long, String>();
public void makeCall();
public void receiveCall(long phno);
public void getCallHistory();
public Call getRecentCall();
public long searchContact(String srch);
public void addContact();
public void redial();
}