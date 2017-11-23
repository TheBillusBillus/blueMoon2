package cpuLogger;

public class cpuL {

	public String type;
	public String family;
	public String model;
	public String socket;
	public int freq;
	public int freqOC;
	public int fsb;
	public int width;
	public int core;
	public int thread;
	public float multiMin;
	public float multiMax;
	public float vcoreBase;
	public float vcoreMax;
	public float vcoreOC;

	public cpuL(String type, String family, String model, String socket, int freq, int freqOC, int fsb, int width, int core, int thread, float multiMin, float multiMax, float vcoreBase, float vcoreMax, float vcoreOC) {
		this.type = type;
		this.family = family;
		this.model = model;
		this.socket = socket;
		this.freq = freq;
		this.freqOC = freqOC;
		this.fsb = fsb;
		this.width = width;
		this.core = core;
		this.thread = thread;
		this.multiMin = multiMin;
		this.multiMax = multiMax;
		this.vcoreBase = vcoreBase;
		this.vcoreMax = vcoreMax;
		this.vcoreOC = vcoreOC;
	}
	
	public String toString() {
		return this.type + "|" + this.family  + "|" + this.model + "|" + this.socket + "|" + this.freq + "|" + this.freqOC + "|" + this.fsb + "|" + this.width + "|" + this.core + "|" + this.thread + "|" + this.multiMin + "|" + this.multiMax + "|" + this.vcoreBase + "|" + this.vcoreMax + "|" + this.vcoreOC + "|";
	}
}
