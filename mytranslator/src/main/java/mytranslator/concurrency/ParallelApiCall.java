package mytranslator.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import mytranslator.oxford.api.ApiCallable;

/**
 * Class that performs parallel calls to Oxford Dictionaries API.
 * 
 * @author pborsoni
 *
 */
public class ParallelApiCall {

	private List<String> callableList;

	public ParallelApiCall(List<String> callableList) {
		super();
		this.callableList = callableList;
	}

	public List<String> performApiCalls() throws Exception {

		List<String> responseList = new ArrayList<>();

		if (callableList == null || callableList.isEmpty()) {
			return responseList;
		}

		List<FutureTask<String>> taskList = new ArrayList<>();

		for (String callable : callableList) {
			taskList.add(new FutureTask<String>(new ApiCallable(callable)));
		}

		ExecutorService executor = Executors.newFixedThreadPool(taskList.size());

		for (FutureTask<String> task : taskList) {
			executor.execute(task);
		}

		try {
			for (FutureTask<String> task : taskList) {
				responseList.add(task.get());
			}
		} catch (Exception e) {
			throw new Exception("Error performing parallel calls. ", e);
		} finally {
			executor.shutdown();
		}

		return responseList;

	}
}
