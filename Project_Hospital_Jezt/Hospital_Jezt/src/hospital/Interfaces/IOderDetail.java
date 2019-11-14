package hospital.Interfaces;

import java.util.List;

import hospital.Entities.OderDetail;

public interface IOderDetail {
	
	public List<OderDetail> getOderDetail(int odId);
	public boolean inserOderDetail(OderDetail odd);
}
