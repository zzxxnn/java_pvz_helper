package hanshu;

public class Rmemory {
	String ckmc;
	private int hwnd;
	public int jcid;
	private int super1 = 0x1f0fff;
	private int normal = 16;
	
	public Rmemory(String chuangkoumingcheng) {
		this.ckmc = chuangkoumingcheng;
	
		hwnd = User32.INSTANCE.FindWindowA(null, ckmc);
		int[] a = new int[1];
		User32.INSTANCE.GetWindowThreadProcessId(hwnd, a);
		jcid = Kernel32.INSTANCE.OpenProcess(0x1f0fff, false, a[0]);
	}

	public Rmemory() {
		// TODO Auto-generated constructor stub
	}

	public int readMemory(int a) {
		int b = 0;
		int[] c = new int[1];
		Kernel32.INSTANCE.ReadProcessMemory(jcid, a, c, 4, 0);
		b = c[0];
		return b;
	}

	public void writeMemory(int a,int ... b) {
		
		for (int i = 0; i < b.length; i++) {
			int[] d = {b[i]};
			Kernel32.INSTANCE.WriteProcessMemory(jcid, a+i, d, 1, 0);
			 
		}
	}

	public void writeMemory(int a,int b) {
		int[] d = {b};
		Kernel32.INSTANCE.WriteProcessMemory(jcid, a, d, 4, 0);
	}

}
