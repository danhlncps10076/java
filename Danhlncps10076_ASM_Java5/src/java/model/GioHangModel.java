package model;

import java.util.ArrayList;
import java.util.HashMap;

import entities.Item;
import entities.SanPham;

public class GioHangModel {
	HashMap<String, Item> cart;

	public GioHangModel() {
		cart = new HashMap<>();
	}

	public void addSP(String maSP) {
		if (cart.containsKey(maSP)) {
			Item item = cart.get(maSP);
			item.setCount(item.getCount() + 1);
		} else {
			SanPham sp = new SanphamModel().getSPByMSP(maSP);
			Item item = new Item(sp, 1);
			cart.put(String.valueOf(sp.getMaSP()), item);
		}
	}

	public void deleteSP(String maSP) {
		cart.remove(maSP);
	}

	public void deleteAll() {
		cart.clear();
	}

	public void giam(String maSP) {
		Item item = cart.get(maSP);
		if (item.getCount() > 0) {
			item.setCount(item.getCount() - 1);
			if (item.getCount() == 0) {
				deleteSP(maSP);
			}
		}
	}

	public void tang(String maSP) {
		Item item = cart.get(maSP);
		item.setCount(item.getCount() + 1);
		;
	}

	public ArrayList getListItem() {
		ArrayList<Item> listItem = new ArrayList();
		for (Item item : cart.values()) {
			listItem.add(item);
		}
		return listItem;
	}
}
