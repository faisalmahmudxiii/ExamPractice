package preparation.mobapp207.com.exam.Service;

import android.content.Context;

import java.util.List;

import preparation.mobapp207.com.exam.Adapter.QuestionDBHelper;
import preparation.mobapp207.com.exam.Model.QuestionModel;
import preparation.mobapp207.com.exam.UtilityManager;


public class QuestionServiceImpl implements QuestionService {

    @Override
    public List<QuestionModel> GetQuestion(Context context) {

        return QuestionDBHelper.getInstance(context).GetAllQuestion(0,10, UtilityManager.BANGLA_TABLE_NAME);
    }
}
