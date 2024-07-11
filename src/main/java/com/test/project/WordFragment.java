package com.test.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import io.reactivex.annotations.NonNull;


/**
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃  神兽保佑
 * 　　　　┃　　　┃  代码无bug
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━感觉萌萌哒━━━━━━
 *
 * @author hao
 * @date
 * @description
 */

public class WordFragment extends Fragment {

    private TextView tv_name;
    private Button btn1;
    private Button btn3;
    private int a;
    private TextView tv_num;
    private ImageView iv;
    private TextView btn11;
    private TextView btn12;
    private TextView btn13;
    private TextView btn14;
    private boolean isvisible;
    private String m1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_word, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isvisible = true;
    }

    public static WordFragment newInstance(WordBean value) {
        WordFragment fragment = new WordFragment();
        Bundle args = new Bundle();
        args.putSerializable("myValue", value);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        pan(isVisibleToUser);
    }


    private void initView(final View view) {
        tv_name = view.findViewById(R.id.tv_name);
        tv_num = view.findViewById(R.id.tv_num);
        iv = view.findViewById(R.id.iv);
        btn11 = view.findViewById(R.id.btn11);
        btn12 = view.findViewById(R.id.btn12);
        btn13 = view.findViewById(R.id.btn13);
        btn14 = view.findViewById(R.id.btn14);


        btn1 = view.findViewById(R.id.btn1);
        btn3 = view.findViewById(R.id.btn3);

        if (getArguments() != null) {
            final WordActivity activity = (WordActivity) getActivity();
            final WordBean bean = (WordBean) getArguments().getSerializable("myValue");
            tv_name.setText(bean.getName());
            btn11.setText(bean.getDes1());
            btn12.setText(bean.getDes2());
            btn13.setText(bean.getDes3());
            btn14.setText(bean.getDes4());
            tv_num.setText(bean.getPos()+"/"+activity.mAllList.size());
            iv.setImageResource(bean.getPic());
            m1 = "";
            if (bean.getAns() == 0) {
                m1 = bean.getDes1();
            }else  if (bean.getAns() == 1) {
                m1 = bean.getDes2();
            }else  if (bean.getAns() == 2) {
                m1 = bean.getDes3();
            }else {
                m1 = bean.getDes4();
            }

            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    btn3.setText(m1);
                    activity.isRight = true;
                }
            });

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int ans = bean.getAns();
                    if (ans <= 1) {
                        btn13.setVisibility(View.GONE);
                        btn14.setVisibility(View.GONE);
                    }else{
                        btn11.setVisibility(View.GONE);
                        btn12.setVisibility(View.GONE);
                    }
                    activity.isLeft = true;
                }
            });

            btn11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (bean.getAns() == 0) {
                        WordActivity activity = (WordActivity) getActivity();
                        activity.setNext();
                    }else {
                        startActivity(new Intent(getContext(),FailActivity.class));
                        getActivity().finish();
                    }
                }
            });
            btn12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (bean.getAns() == 1) {
                        WordActivity activity = (WordActivity) getActivity();
                        activity.setNext();
                    }else {
                        startActivity(new Intent(getContext(),FailActivity.class));
                        getActivity().finish();
                    }
                }
            });
            btn13.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (bean.getAns() == 2) {
                        WordActivity activity = (WordActivity) getActivity();
                        activity.setNext();
                    }else {
                        startActivity(new Intent(getContext(),FailActivity.class));
                        getActivity().finish();
                    }
                }
            });
            btn14.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (bean.getAns() == 3) {
                        WordActivity activity = (WordActivity) getActivity();
                        activity.setNext();
                    }else {
                        startActivity(new Intent(getContext(),FailActivity.class));
                        getActivity().finish();
                    }
                }
            });
        }


    }

    public void pan(boolean visble) {
        if (isvisible && visble) {
            WordActivity activity = (WordActivity) getActivity();
            if (activity.isLeft) {
                btn1.setVisibility(View.GONE);
            }else {
                btn1.setVisibility(View.VISIBLE);
            }
            if (activity.isRight) {
                btn3.setVisibility(View.GONE);
            }else {
                btn3.setVisibility(View.VISIBLE);
            }
        }
    }
}
