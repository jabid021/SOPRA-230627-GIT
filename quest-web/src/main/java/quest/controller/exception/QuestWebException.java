package quest.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Non trouvé")
public class QuestWebException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public QuestWebException() {
		super();
	}

	public QuestWebException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public QuestWebException(String message, Throwable cause) {
		super(message, cause);
	}

	public QuestWebException(String message) {
		super(message);
	}

	public QuestWebException(Throwable cause) {
		super(cause);
	}

}
