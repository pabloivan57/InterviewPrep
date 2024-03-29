package com.pablan.leetcode.collection.google.medium;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindDuplicatePathInSystem {

    /**
     * Given a list of directory info including directory path, and all the files with contents in this directory,
     * you need to find out all the groups of duplicate files in the file system in terms of their paths.
     *
     * A group of duplicate files consists of at least two files that have exactly the same content.
     *
     * A single directory info string in the input list has the following format:
     *
     * "root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"
     *
     * It means there are n files (f1.txt, f2.txt ... fn.txt with content f1_content, f2_content ... fn_content,
     * respectively) in directory root/d1/d2/.../dm. Note that n >= 1 and m >= 0. If m = 0,
     * it means the directory is just the root directory.
     *
     * The output is a list of group of duplicate file paths. For each group,
     * it contains all the file paths of the files that have the same content.
     * A file path is a string that has the following format:
     *
     * "directory_path/file_name.txt"
     *
     * Example 1:
     *
     * Input:
     * ["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
     * Output:
     * [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
     *
     * Pablo's notes: Intitution tells you two have two maps, content to file and file to directory... but there is no
     * need for this. We simply need content and the filepath where it belongs. At the end we just return the ones that
     * have more than 1 file path
     *
     * root/a 1.txt(abcd)  root/c 3.txt(abcd)
     *
     * abcd -> root/a/1.txt, root/c/e.txt --> Duplicate because I have two filepaths
     *
     */
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> contentGroupings = new HashMap<>();

        for(int i = 0; i < paths.length; i++) {
            String entry = paths[i];

            String[] parts = entry.split(" ");
            String root = parts[0];

            for(int j = 1; j < parts.length; j++) {
                String singlePart = parts[j];
                int contentStart = singlePart.indexOf('(');
                int contentEnd = singlePart.indexOf(')');

                String fileName = singlePart.substring(0, contentStart);
                String filePath = root + "/" +fileName;
                String content = singlePart.substring(contentStart + 1, contentEnd);

                if(!contentGroupings.containsKey(content)) {
                    contentGroupings.put(content, new ArrayList<>());
                }
                contentGroupings.get(content).add(filePath);
            }
        }

        // Here just return the ones that have more than 1 duplicate
        return contentGroupings.values().stream().filter(list -> list.size() > 1).collect(Collectors.toList());
    }
}
