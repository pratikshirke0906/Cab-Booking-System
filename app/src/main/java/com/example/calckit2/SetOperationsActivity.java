package com.example.calckit2;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

        public class SetOperationsActivity extends AppCompatActivity {

            EditText set1EditText, set2EditText;
            Button unionButton, intersectionButton, differenceButton, cartesianButton, cardinalityButton, powerSetButton;
            TextView resultTextView;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_set_operations);
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

                set1EditText = findViewById(R.id.set1EditText);
                set2EditText = findViewById(R.id.set2EditText);
                unionButton = findViewById(R.id.unionButton);
                intersectionButton = findViewById(R.id.intersectionButton);
                differenceButton = findViewById(R.id.differenceButton);
                cartesianButton = findViewById(R.id.cartesianButton);
                cardinalityButton = findViewById(R.id.cardinalityButton);
                powerSetButton = findViewById(R.id.powerSetButton);
                resultTextView = findViewById(R.id.resultTextView);

                unionButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        performUnion();
                    }
                });

                intersectionButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        performIntersection();
                    }
                });

                differenceButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        performDifference();
                    }
                });

                cartesianButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        performCartesianProduct();
                    }
                });

                cardinalityButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        performCardinality();
                    }
                });

                powerSetButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        performPowerSet();
                    }
                });
            }

            private Set<Integer> getSetFromEditText(EditText editText) {
                String input = editText.getText().toString().trim();
                String[] elements = input.split(",");
                Set<Integer> set = new HashSet<>();

                for (String element : elements) {
                    if (!element.isEmpty()) {
                        set.add(Integer.parseInt(element));
                    }
                }

                return set;
            }

            private void performUnion() {
                Set<Integer> set1 = getSetFromEditText(set1EditText);
                Set<Integer> set2 = getSetFromEditText(set2EditText);

                set1.addAll(set2);

                resultTextView.setText("Union: " + set1.toString());
            }

            private void performIntersection() {
                Set<Integer> set1 = getSetFromEditText(set1EditText);
                Set<Integer> set2 = getSetFromEditText(set2EditText);

                set1.retainAll(set2);

                resultTextView.setText("Intersection: " + set1.toString());
            }

            private void performDifference() {
                Set<Integer> set1 = getSetFromEditText(set1EditText);
                Set<Integer> set2 = getSetFromEditText(set2EditText);

                // Find the difference between set1 and set2
                Set<Integer> setDiff1 = new HashSet<>(set1);
                setDiff1.removeAll(set2);

                // Find the difference between set2 and set1
                Set<Integer> setDiff2 = new HashSet<>(set2);
                setDiff2.removeAll(set1);

                // Display the differences in the resultTextView
                resultTextView.setText("Set1 - Set2: " + setDiff1.toString() + "\n" +
                        "Set2 - Set1: " + setDiff2.toString());
            }

            private void performCartesianProduct() {
                Set<Integer> set1 = getSetFromEditText(set1EditText);
                Set<Integer> set2 = getSetFromEditText(set2EditText);

                Set<String> cartesianProduct = new HashSet<>();

                for (Integer element1 : set1) {
                    for (Integer element2 : set2) {
                        cartesianProduct.add("(" + element1 + ", " + element2 + ")");
                    }
                }

                resultTextView.setText("Cartesian Product: " + cartesianProduct.toString());
            }

            private void performCardinality() {
                Set<Integer> set1 = getSetFromEditText(set1EditText);
                Set<Integer> set2 = getSetFromEditText(set2EditText);

                int cardinalitySet1 = set1.size();
                int cardinalitySet2 = set2.size();

                resultTextView.setText("Cardinality Set1: " + cardinalitySet1 + "\n" +
                        "Cardinality Set2: " + cardinalitySet2);
            }


            private void performPowerSet() {
                Set<Integer> set1 = getSetFromEditText(set1EditText);

                Set<Set<Integer>> powerSet = new HashSet<>();
                powerSet.add(new HashSet<>()); // Empty set is always part of the power set

                for (Integer element : set1) {
                    Set<Set<Integer>> newSubsets = new HashSet<>();

                    for (Set<Integer> subset : powerSet) {
                        Set<Integer> newSubset = new HashSet<>(subset);
                        newSubset.add(element);
                        newSubsets.add(newSubset);
                    }

                    powerSet.addAll(newSubsets);
                }

                resultTextView.setText("Power Set: " + powerSet.toString());
            }
        }
