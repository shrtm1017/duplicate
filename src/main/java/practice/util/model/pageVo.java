package practice.util.model;

public class pageVo {
		private int page; // 페이지번호
		private int pageSize; // 페이지당 사이즈
//		private int board_no;
	
		public pageVo() {
			
		}
//		public int getBoard_no() {
//			return board_no;
//		}
//		public void setBoard_no(int board_no) {
//			this.board_no = board_no;
//		}
		public pageVo(int page, int pageSize) {
			this.page=page;
			this.pageSize=pageSize;
		}
		public int getPage() {
			return page == 0 ? 1 : page; // 페이지 수식
		}
		public void setPage(int page) {
			this.page = page;
		}
		public int getPageSize() {
			return pageSize == 0 ? 10 : pageSize;
		}
		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}
		@Override
		public String toString() {
			return "pageVo [page=" + page + ", pageSize=" + pageSize + "]";
		}
		

}
