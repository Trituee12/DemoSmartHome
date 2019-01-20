package baithi.tuentpd01983.repositoryImpl;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import baithi.tuentpd01983.entity.DeviceStatus;
import baithi.tuentpd01983.entity.HistoryStatus;
import baithi.tuentpd01983.repository.HistoryStatusRepository;
import baithi.tuentpd01983.services.HistoryStatusServices;

@Service
public class HistoryStatusRepositoryImpl implements HistoryStatusServices {
	
	@Autowired
	private HistoryStatusRepository  historyStatusRepository;

	@Override
	public Iterable<HistoryStatus> findall() {
		// TODO Auto-generated method stub
		return historyStatusRepository.findAll();
	}

	@Override
	public Optional<HistoryStatus> findById(Long id) {
		// TODO Auto-generated method stub
		return historyStatusRepository.findById(id);
	}

	@Override
	public HistoryStatus save(HistoryStatus historyStatus) {
		// TODO Auto-generated method stub
		return historyStatusRepository.save(historyStatus);
	}

	@Override
	public long Count() {
		// TODO Auto-generated method stub
		return historyStatusRepository.count();
	}

	@Override
	public Iterable<HistoryStatus> findHistoryByUser(String username) {
		// TODO Auto-generated method stub
		return historyStatusRepository.findHistoryByUser(username);
	}

	

	
}
