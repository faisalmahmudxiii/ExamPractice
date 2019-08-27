package preparation.mobapp207.com.exam.Service;

import android.content.Context;

import java.util.List;

import preparation.mobapp207.com.exam.Model.QuestionModel;

public  interface QuestionService {

    List<QuestionModel> GetQuestion(Context context);
}
