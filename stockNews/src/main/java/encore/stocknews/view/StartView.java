package encore.stocknews.view;

import encore.stocknews.controller.StockNewsController;
import encore.stocknews.model.dto.NewsUser;
import encore.stocknews.model.util.DBUtil;

public class StartView {
	public static StockNewsController controller = StockNewsController.getInstance();

	public static void main(String[] args) {
		// Factory 실행
		DBUtil.runFactory();
		// (웹으로 했을 경우 및 기타 상황에서) 로그인 또는 프로세스 스타드 등 factoty 생성 및 반환 시점에 대한 고민 필요
		try {
			// 크롤링
//			controller.crawling();
			// 유저 전체 검색
			System.out.println("== 전체 검색 ==");
			controller.getNewsUserList();
			// 유저 추가
			System.out.println("== 유저 추가 ==");
			NewsUser newsUser = new NewsUser();
			newsUser.setId("kimbc");
			newsUser.setPw("mart");
			newsUser.setName("김병철");
			controller.addNewsUser(newsUser, "기아차");
			// 유저 전체 검색
			System.out.println("== 전체 검색 ==");
			controller.getNewsUserList();
			// 유저 개인 검색 + 뉴스 발송
			System.out.println("== 개인 검색 ==");
			controller.getNewsUser("kimbc");
			controller.sendStockNewsList("kimbc");
			// 유저 개인 업데이트 + 개인 검색
			System.out.println("== 유저 업데이트 ==");
			controller.updateNewsUser("kimbc", "현대건설");
			System.out.println("== 개인 검색 ==");
			controller.getNewsUser("kimbc");
			controller.sendStockNewsList("kimbc");
			// 유저 개인 삭제 + 개인 검색
			System.out.println("== 유저 삭제 ==");
			controller.deleteNewsUser("kimbc");
			System.out.println("== 개인 검색 ==");
			controller.getNewsUser("kimbc");
			// 한 종목 검색
			System.out.println("== 한 종목 검색 ==");
			controller.getStock("삼성전자");
			// 모든 종목 검색
			System.out.println("== 모든 종목 검색 ==");
			controller.getStockList();

		} finally {
			// Factory 반환
			DBUtil.closeFactory();
		}
	}
}
