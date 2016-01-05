package com.epam.note.dao.impl;

import com.epam.note.dao.INoteDao;
import com.epam.note.model.Note;
import com.epam.note.util.DBConnection;
import com.epam.note.util.SQLCloser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoteDao implements INoteDao {

    private final static String SELECT_ALL_NOTES = "SELECT * FROM note";
    private final static String SELECT_NOTE = "SELECT * FROM note WHERE id = ?";
    private final static String INSERT = "INSERT INTO note (date_note, title, category, description) VALUES (?, ?, ?, ?)";
    private final static String DELETE = "DELETE FROM note WHERE id = ?";
    private final static String UPDATE = "UPDATE note SET title = ?, category = ?, description = ? WHERE id = ?";

    private Connection connection;

    public NoteDao() {
        connection = DBConnection.getConnection();
    }

    @Override
    public void add(Note note) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setDate(1, new Date(note.getDate().getTime()));
            preparedStatement.setString(2, note.getTitle());
            preparedStatement.setString(3, note.getCategory());
            preparedStatement.setString(4, note.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SQLCloser.close(preparedStatement);
        }
    }

    @Override
    public void delete(int noteId) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, noteId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SQLCloser.close(preparedStatement);
        }
    }

    @Override
    public void update(Note note) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, note.getTitle());
            preparedStatement.setString(2, note.getCategory());
            preparedStatement.setString(3, note.getDescription());
            preparedStatement.setInt(4, note.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }//TODO close all statements and result sets
        finally {
            SQLCloser.close(preparedStatement);
        }
    }

    @Override
    public List<Note> getAll() {
        List<Note> notes = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_ALL_NOTES);
            while (resultSet.next()) {
                Note note = new Note();
                note.setId(resultSet.getInt("id"));
                note.setDate(resultSet.getDate("date_note"));
                note.setTitle(resultSet.getString("title"));
                note.setCategory(resultSet.getString("category"));
                note.setDescription(resultSet.getString("description"));
                notes.add(note);
            }
        } catch (SQLException e) {
            e.printStackTrace();//TODO handle all exceptions
        } finally {
            SQLCloser.close(resultSet);
            SQLCloser.close(statement);
        }
        return notes;
    }

    @Override
    public Note getById(int notesId) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Note note = new Note();
        try {
            preparedStatement = connection.prepareStatement(SELECT_NOTE);
            preparedStatement.setInt(1, notesId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                note.setId(resultSet.getInt("id"));
                note.setDate(resultSet.getDate("date_note"));
                note.setTitle(resultSet.getString("title"));
                note.setCategory(resultSet.getString("category"));
                note.setDescription(resultSet.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            SQLCloser.close(resultSet);
            SQLCloser.close(preparedStatement);
        }
        return note;
    }
}
