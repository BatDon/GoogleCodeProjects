package com.test.table.recyclerview;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> implements
    View.OnClickListener{

    private final LinkedList<String> mWordList;
    private LayoutInflater mInflater;
    private WordListAdapter mAdapter;
    RecyclerView mRecyclerView;


    public WordListAdapter(Context context, LinkedList<String> wordList, RecyclerView recyclerView) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
        mRecyclerView=recyclerView;
    }

    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View mItemView=mInflater.inflate(R.layout.word_list_item, parent,false);
        View mItemView=mInflater.inflate(R.layout.word_list_item, parent,false);
        mItemView.setOnClickListener(this);
        return new WordViewHolder(mItemView,this);
    }

    @Override
    public void onClick(View view) {
        // Get the position of the item that was clicked.
        int mPosition = mRecyclerView.getChildLayoutPosition(view);
// Use that to access the affected item in mWordList.
        String element = mWordList.get(mPosition);
// Change the word in the mWordList.
        mWordList.set(mPosition, "Clicked! " + element);
// Notify the adapter, that the data has changed so it can
// update the RecyclerView to display the data.
        mAdapter.notifyDataSetChanged();
    }

    class WordViewHolder extends RecyclerView.ViewHolder{
        public final TextView wordItemView;


        public WordViewHolder(@NonNull View itemView, WordListAdapter adapter) {
            super(itemView);
            mAdapter=adapter;
            wordItemView=itemView.findViewById(R.id.word);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        String mCurrent=mWordList.get(position);
        holder.wordItemView.setText(mCurrent);

    }

    @Override
    public int getItemCount() {
        if(mWordList!=null){
            return mWordList.size();
        }
        return 0;
    }
}
