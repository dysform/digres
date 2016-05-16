DigitalReasoning assignment

Part1

Sentence splitting assumptions:

sentence ends with a . or ? or !
followed by " and whitespaces or just whitespaces
followed by a capital letter

A sentence is an index into the text document
A sentence includes the whitespace following it
A sentence contains index for end of character portion (before whitespace)

Word split assumptions

a word boundary is whitespace->nonwhitespace until nonwhitespace->whitespace
include whitespace and punctuation within the word object
store indeces into the full sentence text for symbol and punctuation boundaries

XML output

was not sure exactly what was required here
A document has document text field
A list of sentence fields
Each sentence field has a list of word fields

in memory the actual strings for words and sentences are not stored
but for the xml I included output just to be able to see the results in file
the text is not necessary to read the model back in, just the indeces

Part2

Added named entity recognition

algorithm

find islands of contiguous capitalized words in a sentence
for each combination within an islnad see if it exists in the set of
named entities

in XML
a list of named entities is added to each sentence (for show)
and a master list is added at the end

Part3

Multithreaded processing, a thread per file
Results collected back into a list of documents
final xml has only the master list of entities
but each sentence also has them
depending on requirenments, the individual sentence named entities don't need to be shown

The XML output could probably be a little better given exact requirenments