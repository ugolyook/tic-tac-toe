package com.sveta.collections.map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RedBlackTreeTest {
    @Test
    void insert_singleElement_expectElementExists() {
        // given
        RedBlackTree<Integer> tree = new RedBlackTree<>();

        // when
        tree.insert(10);

        // then
        assertTrue(tree.contains(10));
    }

    @Test
    void insert_multipleElements_expectAllExist() {
        // given
        RedBlackTree<Integer> tree = new RedBlackTree<>();

        // when
        tree.insert(10);
        tree.insert(5);
        tree.insert(20);

        // then
        assertTrue(tree.contains(10));
        assertTrue(tree.contains(5));
        assertTrue(tree.contains(20));
    }

    @Test
    void delete_leafNode_expectRemoved() {
        // given
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        tree.insert(10);
        tree.insert(5);
        tree.insert(20);

        // when
        tree.delete(5);

        // then
        assertFalse(tree.contains(5));
        assertTrue(tree.contains(10));
        assertTrue(tree.contains(20));
    }

    @Test
    void delete_nodeWithOneChild_expectRemoved() {
        // given
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        tree.insert(10);
        tree.insert(5);
        tree.insert(1);

        // when
        tree.delete(5);

        // then
        assertFalse(tree.contains(5));
        assertTrue(tree.contains(1));
        assertTrue(tree.contains(10));
    }

    @Test
    void delete_nodeWithTwoChildren_expectRemoved() {
        // given
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        tree.insert(10);
        tree.insert(5);
        tree.insert(20);
        tree.insert(15);
        tree.insert(25);

        // when
        tree.delete(20);

        // then
        assertFalse(tree.contains(20));
        assertTrue(tree.contains(15));
        assertTrue(tree.contains(25));
    }

    @Test
    void delete_root_expectTreeStillValid() {
        // given
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        tree.insert(10);
        tree.insert(5);
        tree.insert(20);

        // when
        tree.delete(10);

        // then
        assertFalse(tree.contains(10));
        assertTrue(tree.contains(5));
        assertTrue(tree.contains(20));
    }

    @Test
    void delete_nonExistingElement_expectNoChanges() {
        // given
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        tree.insert(10);
        tree.insert(5);

        // when
        tree.delete(100);

        // then
        assertTrue(tree.contains(10));
        assertTrue(tree.contains(5));
    }

    @Test
    void insertAndDelete_manyElements_expectEmptyTree() {
        // given
        RedBlackTree<Integer> tree = new RedBlackTree<>();

        // when
        for (int i = 1; i <= 50; i++) {
            tree.insert(i);
        }

        for (int i = 1; i <= 50; i++) {
            tree.delete(i);
        }

        // then
        for (int i = 1; i <= 50; i++) {
            assertFalse(tree.contains(i));
        }
    }
}