package com.lec.ex09_store;
// 주택가 1호점 : 부대찌개-8,000, 순대국-안팔아 
// StoreNum1 store1 = new StoreNum1("주택가 1호점");
public class StoreNum1 extends HeadQuarterStore {
	public StoreNum1(String storeName) {
		super(storeName);
	}
	@Override
	public void bude() {
		System.out.println("부대찌개-8,000");
	}
	@Override
	public void sunde() {
		System.out.println("순대국-안팔아");
	}
}