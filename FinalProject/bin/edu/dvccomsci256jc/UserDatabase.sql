CREATE DATABASE chordBase
CHARACTER SET utf8;

USE chordBase;
Create Table chords{
I VARCHAR(10) Primary Key Auto_Increment,
II VARCHAR(10),
III VARCHAR(10),
IV VARCHAR(10),
V VARCHAR(10),
VI VARCHAR(10),
VII VARCHAR(10)
}

Create Table userProg{
cs VARCHAR(10) }

INSERT INTO chords (I, II, III, IV, V, VI, VII)
VALUES
    ('C', 'Dm', 'Em', 'F', 'G', 'Am', 'Bdim'),
    ('G', 'Am', 'Bm', 'C', 'D', 'Em', 'F#dim'),
    ('D', 'Em', 'F#m', 'G', 'A', 'Bm', 'C#dim'),
    ('A', 'Bm', 'C#m', 'D', 'E', 'F#m', 'G#dim'),
    ('E', 'F#m', 'G#m', 'A', 'B', 'C#m', 'D#dim'),
    ('B', 'C#m', 'D#m', 'E', 'F#', 'G#m', 'A#dim'),
    ('F#', 'G#m', 'A#m', 'B', 'C#', 'D#m', 'Fdim'),
    ('Db', 'Ebm', 'Fm', 'Gb', 'Ab', 'Bbm', 'Cdim'),
    ('Ab', 'Bbm', 'Cm', 'Db', 'Eb', 'Fm', 'Gdim'),
    ('Eb', 'Fm', 'Gm', 'Ab', 'Bb', 'Cm', 'Ddim'),
    ('Bb', 'Cm', 'Dm', 'Eb', 'F', 'Gm', 'Adim'),
    ('F', 'Gm', 'Am', 'Bb', 'C', 'Dm', 'Edim');

-- Insert chord progressions for natural minor scales
INSERT INTO chords (I, II, III, IV, V, VI, VII)
VALUES
    ('Am', 'Bdim', 'C', 'Dm', 'Em', 'F', 'G'),
    ('Dm', 'Edim', 'F', 'Gm', 'Am', 'Bb', 'C'),
    ('Em', 'F#dim', 'G', 'Am', 'Bm', 'C', 'D'),
    ('Bm', 'C#dim', 'D', 'Em', 'F#m', 'G', 'A'),
    ('Gm', 'Adim', 'Bb', 'Cm', 'Dm', 'Eb', 'F'),
    ('Cm', 'Ddim', 'Eb', 'Fm', 'Gm', 'Ab', 'Bb'),
    ('Fm', 'Gdim', 'Ab', 'Bbm', 'Cm', 'Db', 'Eb'),
    ('Bbm', 'Cdim', 'Db', 'Ebm', 'Fm', 'Gb', 'Ab'),
    ('Ebm', 'Fdim', 'Gb', 'Abm', 'Bbm', 'Cb', 'Db'),
    ('Abm', 'Bbdim', 'Cb', 'Dbm', 'Ebm', 'Fb', 'Gb'),
    ('Dbm', 'Edim', 'Fb', 'Gbm', 'Abm', 'Bbm', 'Cbm'),
    ('Gbm', 'Abdim', 'Bbb', 'Cbm', 'Dbm', 'Ebb', 'Fb');

-- View the contents of the chords table
SELECT * FROM chords;