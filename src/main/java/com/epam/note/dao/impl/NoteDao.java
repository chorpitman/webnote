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
    private final static String INSERT = "INSERT INTO note (note_date, title, category, description) VALUES (?, ?, ?, ?)";
    private final static String DELETE = "DELETE FROM note WHERE id = ?";
    private final static String UPDATE = "UPDATE note SET title = ?, category = ?, description = ? WHERE id = ?";
    private final static String GET_LAST_ID = "SELECT LAST_INSERT_ID() id";


    public NoteDao() {
        connection = DBConnection.getConnection();
    }

    private Connection connection;

    @Override
    public int add(Note note) {
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        ResultSet resultSet = null;
        int noteId = 0;
        try {
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setDate(1, new Date(System.currentTimeMillis()));
            preparedStatement.setString(2, note.getTitle());
            preparedStatement.setString(3, note.getCategory());
            preparedStatement.setString(4, note.getDescription());
            preparedStatement.executeUpdate();

            //find last id
            statement = connection.createStatement();
            resultSet =statement.executeQuery(GET_LAST_ID);
            while (resultSet.next()) {
                noteId = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SQLCloser.close(preparedStatement);
            SQLCloser.close(statement);
            SQLCloser.close(resultSet);
        }
        return noteId;
    }

    @Override
    public void delete(int noteId) {
        if (noteId > 0) {
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
        else {
            System.out.println("Wrong noteId");
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
                note.setDate(resultSet.getDate("note_date").getTime());
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
    public Note getById(int noteId) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Note note = new Note();
        try {
            preparedStatement = connection.prepareStatement(SELECT_NOTE);
            preparedStatement.setInt(1, noteId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                note.setId(resultSet.getInt("id"));
                note.setDate(resultSet.getDate("note_date").getTime());
                note.setTitle(resultSet.getString("title"));
                note.setCategory(resultSet.getString("category"));
                note.setDescription(resultSet.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SQLCloser.close(resultSet);
            SQLCloser.close(preparedStatement);
        }
        return note;
    }
}
