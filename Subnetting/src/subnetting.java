// This class is used to calculate custom subnets used in networking.
// Author: Kevin R. Loughlin
// Date created: 4/20/14
// Date last edited: 11/4/14
public class subnetting
{
	private static String ipAddress, defaultSubMask;
	private static char ipClass;
	private static int subNets, hostsNeeded, subNetsNeeded, bitsBorrowed=0, bits, hosts;
	private static Boolean subNet;
	// default operation if subNetsNeeded and hostsNeeded is NULL...finds for 1 host
	public subnetting(String address)
	{
		ipAddress=address;
		subnetting.subNetsNeeded = 1;
		findClass();
		defaultSubMask();
		calculateNets();
		updateGui();
	}
	// operation if subNetsNeeded or hostsNeeded is filled
	public subnetting(String address, int subNetsNeeded, Boolean subNet)
	{
		ipAddress=address;
		subnetting.subNetsNeeded=subNetsNeeded;
		subnetting.subNet = subNet;
		findClass();
		defaultSubMask();
		calculateNets();
		updateGui();
	}
	// void finds ip class and sets the char and bits
	private static void findClass()
	{
		char ipClassX = ' ';
		if((int)classString()<128){ipClassX='A'; bits=24;}
		else if((int)classString()<192){ipClassX='B'; bits=16;}
		else if((int)classString()<224){ipClassX='C'; bits=8;}
		ipClass=ipClassX;
	}
	// void finds the first int in the ip, used to find ip class
	private static int classString()
	{
      String classString="";
      char period='.';
      int classLength = 0;
      for(int i=0;period != ipAddress.charAt(i); i++){classLength=i;}
      for(int i=0; i<=classLength; i++){classString += ipAddress.charAt(i);}
		return Integer.parseInt(classString);
	}
	// void determines the default submask
	private void defaultSubMask()
	{
		if(ipClass == 'A'){defaultSubMask="255.0.0.0";}
		else if(ipClass == 'B'){defaultSubMask="255.255.0.0";}
		else{defaultSubMask="255.255.255.0";}
	}
	// void is main part of calculations, figures out how many bits and bits borrowed with a do while loop then calculates and sets the subnets and hosts
	private void calculateNets()
	{
		if(subNetsNeeded==1)
		{
			subNets= (int)Math.pow(2, bitsBorrowed);
			hosts= (int)Math.pow(2, (bits - bitsBorrowed));
		}
		else if (subNet == true)
		{
			int i=2, borrowed=1;
			do{
				i=i*2;
				borrowed++;
				subNets = i;
				bitsBorrowed = borrowed;
			}while (subNetsNeeded > i);
			subNets= (int)Math.pow(2, bitsBorrowed);
			hosts= (int)Math.pow(2, (bits - bitsBorrowed));
		}
		else {
			hostsNeeded = subNetsNeeded;
			int i=1, borrowed=bits;
			do{
				i=i*2;
				borrowed--;
				hosts = i;
				bitsBorrowed = borrowed;
			}while(hostsNeeded > i);
			subNets= (int)Math.pow(2, bitsBorrowed);
			hosts= (int)Math.pow(2, (bits - bitsBorrowed));
		}
	}
	// void updates the GUI used in java
	// NOTE: if incorporated in android it needs to be changed
	public static void updateGui()
	{
		gui.outputIpAddress.setText(ipAddress);
		gui.outputDefaultSubMask.setText(defaultSubMask);
		gui.outputSubNets.setText(Integer.toString(subNets));
		gui.outputHosts.setText(Integer.toString(hosts));
	}
	// setters and getters
	public static void setIp(String ip)
	{
		ipAddress=ip;
	}
	public void setSubNetsNeeded(int subNetsNeeded)
	{
		subnetting.subNetsNeeded=subNetsNeeded;
	}
}