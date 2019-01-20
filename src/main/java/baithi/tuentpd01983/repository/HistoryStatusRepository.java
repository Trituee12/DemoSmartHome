package baithi.tuentpd01983.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import baithi.tuentpd01983.entity.HistoryStatus;

@Repository
public interface HistoryStatusRepository extends JpaRepository<HistoryStatus, Long> {
	@Query(value = "select a.* from history_status a inner join device_status b on a.device_status_id = b.status_id inner join device c on b.device_id = c.device_id\r\n" + 
			"inner join area_device d on c.id = d.id inner join area e on d.area_id = e.area_id inner join user f on e.user_id = f.user_id where f.user_name = ?1", nativeQuery = true)
	Iterable<HistoryStatus> findHistoryByUser(String username);

}
