package presenter;

import view.View;
//import model.Model;

public class Presenter {
		private View view;

		public Presenter(View view) {
				this.view = view;
		}

		public void start() {
			
		}

		public static void main(String[] args) {
				Presenter presenter = new Presenter(new View());
				presenter.start();
		}
}
