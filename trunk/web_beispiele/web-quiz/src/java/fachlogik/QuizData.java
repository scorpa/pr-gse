package fachlogik;

import java.util.List;

/**
 *
 * @author Rudolf Radlbauer
 */
public interface QuizData
{
    public List<Frage> fragen() throws QuizException;
    public void close() throws QuizException;
}
