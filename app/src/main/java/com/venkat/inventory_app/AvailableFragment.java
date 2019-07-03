package com.venkat.inventory_app;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;


public class AvailableFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_available, null);

        FirebaseFirestore db=FirebaseFirestore.getInstance();
        CollectionReference notebookRef=db.collection("Notebook");

        ItemAdapter adapter;

        Query query = notebookRef.orderBy("count", Query.Direction.DESCENDING);

        FirestoreRecyclerOptions<Itemshow> options = new FirestoreRecyclerOptions.Builder<Itemshow>()
                .setQuery(query, Itemshow.class)
                .build();

        adapter= new ItemAdapter(options);
        RecyclerView recyclerViewu = rootView.findViewById(R.id.Recyviewu);
//        recyclerViewu.findViewById((R.id.Recyviewu));
        recyclerViewu.setHasFixedSize(true);
        recyclerViewu.setAdapter(adapter);
        recyclerViewu.setLayoutManager(new LinearLayoutManager(getActivity()));
        return rootView;
    }
}
