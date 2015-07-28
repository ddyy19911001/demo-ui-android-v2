package io.rong.app10.conversationlist.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.rong.app10.R;
import io.rong.imkit.fragment.ConversationListFragment;
import io.rong.imlib.model.Conversation;

/**
 * Created by Bob on 15/7/28.
 * 会话列表动态集成
 */
public class ConversationListDynamicFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.rong_activity, container, false);

        ConversationListFragment fragment = new ConversationListFragment();
        Uri uri = Uri.parse("rong://" +getActivity().getApplicationInfo().packageName).buildUpon()
                .appendPath("conversationlist")
                .appendQueryParameter(Conversation.ConversationType.PRIVATE.getName(), "true") //设置私聊会话是否聚合显示
                .appendQueryParameter(Conversation.ConversationType.GROUP.getName(), "true")
                .appendQueryParameter(Conversation.ConversationType.DISCUSSION.getName(), "false")
                .appendQueryParameter(Conversation.ConversationType.SYSTEM.getName(), "true")
                .build();
        fragment.setUri(uri);

        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//xxx 为你要加载的 Id
        transaction.add(R.id.rong_content, fragment);
        transaction.commit();
        return view;
    }
}
