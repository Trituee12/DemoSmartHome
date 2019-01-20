package baithi.tuentpd01983.services;

import java.util.Optional;

import baithi.tuentpd01983.entity.HistoryStatus;

public interface HistoryStatusServices {

	public Iterable<HistoryStatus> findall();
	
	public Optional<HistoryStatus> findById(Long id);
	
	public HistoryStatus save(HistoryStatus historyStatus);
	
	public long Count();

	public Iterable<HistoryStatus> findHistoryByUser(String username);

	
}
