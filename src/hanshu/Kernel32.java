package hanshu;

import com.sun.jna.Native;
import com.sun.jna.win32.StdCallLibrary;

public interface Kernel32 extends StdCallLibrary {

	Kernel32 INSTANCE = (Kernel32) Native.loadLibrary("Kernel32",
			Kernel32.class);

	int OpenProcess(int dwDesiredAccess, boolean bInheritHandle, int dwProcessId);

	boolean ReadProcessMemory(int hProcess, int lpBaseAddress, int[] lpBuffer,
			int nSize, int lpNumberOfBytesRead);

	boolean CloseHandle(int hObject);
	
	boolean WriteProcessMemory(int hProcess, int lpBaseAddress, int[] lpBuffer,
			int nSize, int lpNumberOfBytesRead);
	boolean WriteProcessMemory(int hProcess, int lpBaseAddress, byte[] lpBuffer,
			int nSize, int lpNumberOfBytesRead);
	

}
