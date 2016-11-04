package com.jingchen.autoload;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * 更多详解见博客http://blog.csdn.net/zhongkejingwang/article/details/38963177
 *
 * @author chenjing
 */
public class MainActivity extends Activity {

    private PullableListView listView;
    private MyAdapter adapter;
    private PullToRefreshLayout pullToRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        pullToRefreshLayout = ((PullToRefreshLayout) findViewById(R.id.refresh_view));
        listView = (PullableListView) findViewById(R.id.content_view);

        initListView();
    }

    /**
     * ListView初始化方法
     */
    private void initListView() {
        List<String> items = new ArrayList<String>();
        for (int i = 0; i < 1; i++) {
            items.add("这里是item " + i);
        }
        adapter = new MyAdapter(this, items);
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {
                Toast.makeText(
                        MainActivity.this,
                        "LongClick on "
                                + parent.getAdapter().getItemId(position),
                        Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MainActivity.this,
                        " Click on " + parent.getAdapter().getItemId(position),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

}
