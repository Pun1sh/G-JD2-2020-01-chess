package by.itacademy.karpuk.chess.web.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UsersHolderWithExpiration {

	public static UsersHolderWithExpiration INSTANCE = new UsersHolderWithExpiration(2000);

	private int expirationMs;

	private Map<Integer, Date> map = new HashMap<Integer, Date>();

	private UsersHolderWithExpiration(int expirationMs) {
		this.expirationMs = expirationMs;
	}

	public synchronized void put(Integer object) {
		map.put(object, new Date());
	}

	public synchronized List<Integer> getAll() {
		long current = new Date().getTime();
		return new HashMap<Integer, Date>(map).entrySet().stream().filter((entry) -> {
			long deltaMs = current - entry.getValue().getTime();
			boolean isNotExpired = deltaMs < expirationMs;
			if (!isNotExpired) {
				map.remove(entry.getKey());
			}

			return isNotExpired;
		}).map((entry) -> {
			return entry.getKey();
		}).collect(Collectors.toList());
	}
}